package com.rainbowred.common.util;

import com.google.common.collect.Lists;
import com.rainbowred.pojo.ElementPojo;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Desc: todo: 层级结构
 * @Date: 2022/11/2 20:44
 * @Author: pengweibiao
 **/
public class ElementUtil<T extends ElementPojo> {


    /**
     * 组装层级结构
     * @param list
     * @return
     */
    public List<T> transferMenuList(List<T> list) {
        // 结果集
        List<T> resultList = new ArrayList<>();
        // 转id Map
        Map<String, T> idMap = list.stream().collect(Collectors.toMap(T::getId, o -> o));
        for (String id : idMap.keySet()) {
            // 遍历结果
            T pojo = idMap.get(id);
            // 父级id
            String parentId = pojo.getParentId();
            if (StringUtil.isEmpty(parentId)) {
                resultList.add(pojo);
            }else {
                // 查出父节点
                T parentPojo = idMap.get(parentId);

                if (Objects.nonNull(parentPojo)) {
                    List<T> children = parentPojo.getChildren();
                    // 放入层级关系中
                    if (CollectionUtils.isEmpty(children)) {
                        parentPojo.setChildren(Lists.newArrayList(pojo));
                    }else {
                        children.add(pojo);
                    }
                }else {
                    resultList.add(pojo);
                }
            }
        }
        // 排序层级结构
        for (T T : resultList) {
            List<T> children = T.getChildren();
            if (CollectionUtils.isEmpty(children)) {
                continue;
            }
            // 根据 orderNo 排序
            children.sort(new Comparator<T>() {
                @Override
                public int compare(T o1, T o2) {
                    return o1.getOrderNo() - o2.getOrderNo();
                }
            });
        }
        // 排序
        resultList.sort(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.getOrderNo() - o2.getOrderNo();
            }
        });
        return resultList;
    }

    /**
     * 拆解层级结构
     */
    public List<T> structBroken(List<T> list) {
        List<T> res = new ArrayList<>();
        for (T t : list) {
            List children = t.getChildren();
            if (CollectionUtils.isEmpty(children)) {
                res.add(t);
            }else {
                res.addAll(structBroken(children));
            }
        }
        return res;
    }

}
