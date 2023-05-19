package com.rainbowred.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

/**
 * @Desc: 官网部署行为 交互数据
 * @Date: 2023/1/15 00:42
 * @Author: pengweibiao
 **/
@Data
public class PushPojo extends BasePojo {

    public PushPojo(){}

    /**
     * 更新html部署参数
     * @param zipFileUrl 访问zip地址
     * @param pushId 此次更新的唯一id
     * @param updateUrl 需要更新的相对路径
     */
    public PushPojo(String token, String type, String zipFileUrl, String pushId, List<String> updateUrl){
        this.zipFileUrl = zipFileUrl;
        this.pushId = pushId;
        this.updateUrl = updateUrl;
        this.type = type;
        this.token = token;
    }

    /**
     * 更新assets文件夹参数
     * @param pushId 此次更新的唯一id
     */
    public PushPojo(String pushId, String token, String type) {
        this.type = type;
        this.pushId = pushId;
        this.token = token;
    }

    /**
     * 推送唯一ID
     */
    @JSONField(name = "PushId")
    private String pushId;

    /**
     * 压缩文件访问路径
     */
    @JSONField(name = "ZipFileUrl")
    private String zipFileUrl;

    /**
     * 部署类型。1：html文件，2：assets静态文件夹
     */
    private String type;

    /**
     * 校验凭证
     */
    private String token;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 更新的文件列表
     */
    @JSONField(name = "UpdateUrl")
    private List<String> updateUrl;

    /**
     * 回传返回状态
     */
    private String status;

}
