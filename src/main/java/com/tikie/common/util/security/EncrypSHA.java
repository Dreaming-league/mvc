package com.tikie.common.util.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *  单向加密
 *
 * SHA 是一种数据加密算法，该算法经过加密专家多年来的发展和改进已日益完善，现在已成为公认的最安全的散列算法之一，并被广泛使用。
 * 该算法的思想是接收一段明文，然后以一种不可逆的方式将它转换成一段（通常更小）密文，也可以简单的理解为取一串输入码（称为预映射或信息），
 * 并把它们转化为长度较短、位数固定的输出序列即散列值（也称为信息摘要或信息认证代码）的过程。
 * 散列函数值可以说时对明文的一种“指纹”或是“摘要”所以对散列值的数字签名就可以视为对此明文的数字签名。
 */
public class EncrypSHA {

    public byte[] eccrypt(String info) throws NoSuchAlgorithmException{
        MessageDigest md5 = MessageDigest.getInstance("SHA");
        byte[] srcBytes = info.getBytes();
        //使用srcBytes更新摘要
        md5.update(srcBytes);
        //完成哈希计算，得到result
        byte[] resultBytes = md5.digest();
        return resultBytes;
    }

    /**
     * @param args
     * @throws NoSuchAlgorithmException
     */
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String msg = "郭XX-精品相声技术";
        EncrypSHA sha = new EncrypSHA();
        byte[] resultBytes = sha.eccrypt(msg);
        System.out.println("明文是：" + msg);
        System.out.println("密文是：" + new String(resultBytes));

    }

}