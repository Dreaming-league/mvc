package com.tikie.common.util.security;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

/**
 * 关于文件的哈希算法
 *
 * 一般来说同一哈希算法对同一文件(镜像、扩展名被修改)所产生的结果应该是一致的
 * 因此有个猜想，在baidu文库、腾讯的群共享上传时，先会判断是否有相同文件，从某种可能上来说也采用了对文件的哈希算法，
 * 毕竟从本地运算一个哈希算法后获得的数值要比把整个文件传过去比较实惠得多。而且字符串的比较也是很方便的。
 *
 * 对于某一种哈希算法，存在一种可能：就是两个不同的文件，计算出来的哈希值可能是一样的。
 * 当然为了保险，可以用两种甚至更多的哈希算法，只有在每种算法获得的哈希值都相同时，才能判断是同一个文件。
 *
 * 如果我们也对用户上传的文件进行哈希计算的话，就可以节省资源，同样的文件按理说可以减少上传次数……
 */
public class FileHashUtil {

    public static final char[] hexChar = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
    public static final String[] hashTypes = new String[] { "MD2", "MD5", "SHA1", "SHA-256", "SHA-384", "SHA-512" };

    public void MD5File(String fileName) throws Exception{
        //String fileName = args[0];
        System.out.println("需要获取hash的文件为：　" + fileName);
        java.util.List<MessageDigest> mds = new java.util.ArrayList<MessageDigest>();
        for (String hashType : hashTypes) {
            MessageDigest md = MessageDigest.getInstance(hashType);
            mds.add(md);
        }
        InputStream fis = null;
        try {
            fis = new FileInputStream(fileName);
            byte[] buffer = new byte[1024];
            int numRead = 0;
            while ((numRead = fis.read(buffer)) > 0) {
                for (MessageDigest md : mds) {
                    md.update(buffer, 0, numRead);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
        for (MessageDigest md : mds) {
            System.out.println(md.getAlgorithm() + " == " + toHexString(md.digest()));
        }
    }

    public static String toHexString(byte[] b) {
        StringBuilder sb = new StringBuilder(b.length * 2);
        for (int i = 0; i < b.length; i++) {
            sb.append(hexChar[(b[i] & 0xf0) >>> 4]);
            sb.append(hexChar[b[i] & 0x0f]);
        }
        return sb.toString();
    }

    /**
     * 运行描述
     *
     * "D:/hapfish/ShellFolder.java",
     * "D:/hapfish/ShellFolder - 副本.java",
     * "E:/ShellFolder - 副本.java",
     * "E:/ShellFolder.txt",
     * "D:/hapfish/ShellFolder.jpg",
     * 以上五个文件是同一文件经过复制、改扩展名的，最后计算哈希结果是一致的。
     *
     * "E:/ShellFolder增加字符.txt" 增加了几个字符串，就不一样了
     * "D:/hapfish/birosoft.jar" 完全不相关的另外一个文件
     */
    public static void main(String[] args) throws Exception {
        String[] fileName = new String[] {"D:/hapfish/ShellFolder.java","D:/hapfish/ShellFolder - 副本.java",
                "E:/ShellFolder - 副本.java","E:/ShellFolder.txt","D:/hapfish/ShellFolder.jpg",
                "E:/ShellFolder增加字符.txt","D:/hapfish/birosoft.jar"};
        FileHashUtil files  = new FileHashUtil();
        for(int i=0;i<fileName.length;i++){
            files.MD5File(fileName[i]);
        }
    }
}