package com.rainbowred.common.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.rainbowred.common.domain.SystemFile;
import com.rainbowred.pojo.PageParam;

import java.util.List;
import java.util.Map;

/**
* @author pengweibiao
* @description 针对表【system_file(系统附件表)】的数据库操作Service
* @createDate 2022-11-22 14:54:30
*/
public interface SystemFileService extends IService<SystemFile> {

    public static final String DESCRIPTION = "附件";

    /**
     * 分页查询文件列表
     * @param pageParam
     * @return
     */
    PageInfo<SystemFile> pageList(PageParam pageParam);

    /**
     * 根据业务id 查询附件列表
     * @param bizId 业务id
     * @return
     */
    List<SystemFile> selectListByBizId(String bizId);

    /**
     * 根据业务id 查询对应的附件
     * @param bizId 业务id
     * @return
     */
    SystemFile selectOneByBizId(String bizId);

    /**
     * 根据业务id 删除相关附件
     * @param bizId 业务id
     */
    boolean deleteByBizId(String bizId);

    /**
     * 根据业务id列表 删除相关附件
     * @param bizIds 业务id列表
     */
    boolean deleteByBizIds(List<String> bizIds);

    /**
     * 上传业务的唯一附件
     * @param bizId 业务id
     * @param file 附件信息
     */
    void addIgnoreFile(String bizId, SystemFile file);

    /**
     * 附件-业务对象 1：1
     * 新增业务后 附件处理
     * @param url 文件访问路径
     * @param bizId 业务id
     */
    void ObjAddFile(String url, String bizId);

    /**
     * 附件-业务对象 1：1
     * 更新业务后 附件处理
     * @param url 文件访问路径
     * @param bizId 业务id
     */
    void ObjUpdateOneFile(String url, String bizId);

    /**
     * 根据文件id，复制文件，并返回文件数据
     * @param ids 文件id列表
     * @param bizId 业务id
     * @return 用于文本标记的 MRK_ID , 文件访问url map
     */
    Map<String, SystemFile> copyFilesByFileIds(List<String> ids, String bizId);

    /**
     * 根据文件id，查询并复制。
     * @param fileId 文件id
     * @param bizId 业务id
     * @return 文件访问路径
     */
    String copyFileFileId(String fileId, String bizId);

    /**
     * 根据文件id，更新
     * @param fileIds
     * @param bizId
     */
    void updateFileBizId(List<String> fileIds, String bizId);

    /**
     * 复制附件，到html文件夹
     * for 支持静态访问
     */
    List<SystemFile> copyByFileIdsForHtml(List<String> fileIds);

    /**
     * 根据内容页id 获取文件静态地址
     * for 支持静态访问
     * @param bizIds
     * @return
     */
    List<String> getRealPathByBizIds(List<String> bizIds);

}
