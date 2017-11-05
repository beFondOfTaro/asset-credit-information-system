package com.iot.assetcreditinformationsystem.util.token;

import com.iot.assetcreditinformationsystem.util.HmacSHA256Utils;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@Service
@Transactional
public class TokenUtilImp implements TokenUtil {

    private final String KEYWORDS = "IOTstudio";//加密密码

    private static final Logger logger = LoggerFactory.getLogger(TokenUtilImp.class);

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 创建消息摘要
     * 默认过期时间为7天
     *
     * @param digestModel 用于生成digest的模型实体
     * @return
     */
    @Override
    public String createDigest(DigestModel digestModel) {
        return createDigest(digestModel, 7);
    }

    @Override
    public String createDigest(DigestModel digestModel, long expirationTime) {
        logger.info("--------创建digest消息摘要---------");
        //将参数进行base64编码
        String encodedParams = Base64.encodeBase64String(String.valueOf(digestModel.getUserId()).getBytes())
                + Base64.encodeBase64String(String.valueOf(digestModel.getCreatedDate().getTime()).getBytes());
        //将编码后的参数进行消息摘要加密
        String digest = HmacSHA256Utils.digest(KEYWORDS, encodedParams);
        //将token存储到redis并设置过期时间
        redisTemplate.boundValueOps(digestModel.getUserId().toString()).set(digest, expirationTime, TimeUnit.DAYS);
        logger.info("用户id:" + digestModel.getUserId() + ",消息摘要已创建：" + digest);
        return digest;
    }

    /**
     * 验证token
     * 验证成功后默认重置token保存时间为7天
     *
     * @return
     */
    @Override
    public boolean validToken(Token clientToken) {
        return validToken(clientToken, 7);
    }

    /**
     * 验证token
     *
     * @param expirationTime 重置token的保存时间(天)
     * @return
     */
    @Override
    public boolean validToken(Token clientToken, long expirationTime) {
        boolean flag = false;
        String userIdInfo;
        if (clientToken != null) {
            userIdInfo = "用户id:" + clientToken.getUserId();
            try {
                //判断token是否存在
                Object serverToken = redisTemplate.boundValueOps(clientToken.getUserId().toString()).get();
                if (serverToken == null || !serverToken.equals(clientToken.getDigest())) {
                    logger.info(userIdInfo + ",与服务端token匹配失败");
                } else {
                    flag = true;
                    redisTemplate.boundValueOps(clientToken.getUserId().toString()).expire(expirationTime, TimeUnit.DAYS);
                    logger.info(userIdInfo + ",token验证通过，重置保存时间为" + expirationTime + "天");
                }

            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        } else {
            logger.info("请求参数token为空，验证失败");
        }
        return flag;
    }

        @Override
        public boolean deleteToken (Integer userId){
            try {
                redisTemplate.delete(userId.toString());
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }
