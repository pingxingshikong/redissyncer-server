package com.i1314i.syncerplusservice.entity.dto;

import com.alibaba.fastjson.JSON;
import com.i1314i.syncerplusservice.entity.dto.common.SyncDataDto;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;
import java.util.Map;


/**
 * 新版dto
 */
@Getter
@Setter
@EqualsAndHashCode

public class RedisClusterDto extends SyncDataDto implements Serializable {
    @NotBlank(message = "源RedisCluster地址不能为空")
    private String sourceRedisAddress;
    @NotBlank(message = "目标RedisCluster地址不能为空")
    private String targetRedisAddress;
    private String sourcePassword;
    private String targetPassword;
    @NotBlank(message = "任务名称不能为空")
    private String threadName;
    @Builder.Default
    private boolean autostart=false;


    public RedisClusterDto(@NotBlank(message = "源RedisCluster地址不能为空") String sourceRedisAddress, @NotBlank(message = "目标RedisCluster地址不能为空") String targetRedisAddress, String sourcePassword, String targetPassword, @NotBlank(message = "任务名称不能为空") String threadName, int minPoolSize, int maxPoolSize, long maxWaitTime, long timeBetweenEvictionRunsMillis, long idleTimeRunsMillis, int diffVersion, String pipeline) {
        super(minPoolSize,maxPoolSize,maxWaitTime,timeBetweenEvictionRunsMillis,idleTimeRunsMillis,diffVersion,pipeline);
        this.sourceRedisAddress = sourceRedisAddress;
        this.targetRedisAddress = targetRedisAddress;
        this.sourcePassword = sourcePassword;
        this.targetPassword = targetPassword;
        this.threadName = threadName;

    }

    public static void main(String[] args) {
        RedisClusterDto dto=new RedisClusterDto("","",
                "","","",10,1,1000
                ,10000,1000,9,"on");
        System.out.println(JSON.toJSONString(dto));
    }

}
