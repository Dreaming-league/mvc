package com.tikie.common.service;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.network.InetAddresses;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * @author zcs
 *         ES工厂类--建立连接等
 *
 *
 *         2016/11/23
 */
@Getter
@Setter
@Log4j
@Service
public class ElasticsearchFactory {
    private TransportClient transportClient;
//    @Autowired
//    private Properties esConfig;//从配置文件读取集群名、超时时间、嗅探全站开关

    public TransportClient getClient() {
        if (null == transportClient) {
//            String[] ips = esConfig.get("es.address").toString().split(";");
            String[] ips = {"127.0.0.1:9300"};
            if(StringUtils.isEmpty(ips))return null;

            Settings settings = Settings.builder()
//                    .put("cluster.name", esConfig.get("es.clusterName"))// 集群名
                    .put("cluster.name","tikie")// 集群名
//                    .put("client.transport.ping_timeout", Integer.parseInt(esConfig.get("es.timeOut").toString()), TimeUnit.SECONDS)
                    //使客户端嗅探整个集群状态，把集群中的其他机器IP加入到客户端中
//                    .put("client.transport.sniff", true)
                    .put("client.transport.sniff", false)
                    // 自动把集群下的机器添加到列表中
                    .build();
            transportClient = new PreBuiltTransportClient(settings);

            //设置集群IP和端口
            for (String add : ips) {
                String[] ip = add.split(":");
                log.debug("ES地址------"+ip[0]+":"+ip[1]);
                try {
                    //InetAddress.getByName(ip[0]
                    TransportAddress transportAddress =  new InetSocketTransportAddress(InetAddresses.forString(ip[0]),Integer.parseInt(ip[1]));
                    transportClient.addTransportAddress(transportAddress);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return transportClient;
    }
}
