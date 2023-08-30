package com.quan.framework.spring.mvc.crypto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quan.framework.spring.mvc.crypto.decrypt.*;
import com.quan.framework.spring.mvc.crypto.encrypt.*;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.List;

/**
 * @author Force-oneself
 * @date 2023-03-03
 */
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(CryptoProperties.class)
public class CryptoAutoConfig {

    /**
     * 加密自动配置
     *
     * @author Force-oneself
     * @date 2023-08-22
     */
    @Configuration(proxyBeanMethods = false)
    @Import({DecryptRequestBodyAdvice.class})
    public static class DecryptAutoConfig {

        @Bean
        public DecryptHandler decryptHandler(List<AdviceDecryptor> decryptors, CryptoProperties properties) {
            return new DefaultDecryptHandler(decryptors, properties);
        }

        @Bean
        public JsonBodyAdviceDecryptorHandler applicationJsonBodyAdviceDecryptorHandler(
                ObjectMapper objectMapper, DecryptHandler decryptHandler) {
            return new JsonBodyAdviceDecryptorHandler(objectMapper, decryptHandler);
        }

        @Bean
        public RSADecryptor rsaDecryptor() {
            return new RSADecryptor();
        }

        @Bean
        public AdviceDecryptor undecryptAdviceDecryptor() {
            return (holder, ciphertext) -> ciphertext;
        }
    }


    /**
     * 解密自动配置
     *
     * @author Force-oneself
     * @date 2023-08-22
     */
    @Configuration(proxyBeanMethods = false)
    @Import({EncryptResponseBodyAdvice.class})
    public static class EncryptAutoConfig {

        @Bean
        public EncryptHandler encryptHandler(List<AdviceEncryptor> encryptors, CryptoProperties properties) {
            return new DefaultEncryptHandler(encryptors, properties);
        }

        @Bean
        public CommonReturnBodyAdviceEncryptorHandler commonReturnBodyAdviceEncryptorHandler(ObjectMapper objectMapper, EncryptHandler encryptHandler) {
            return new CommonReturnBodyAdviceEncryptorHandler(objectMapper, encryptHandler);
        }

        @Bean
        public JsonBodyAdviceEncryptorHandler jsonBodyAdviceEncryptorHandler(ObjectMapper objectMapper, EncryptHandler encryptHandler) {
            return new JsonBodyAdviceEncryptorHandler(objectMapper, encryptHandler);
        }

        @Bean
        public AdviceEncryptor unencryptAdviceEncryptor() {
            return (holder, ciphertext) -> ciphertext;
        }
    }
}
