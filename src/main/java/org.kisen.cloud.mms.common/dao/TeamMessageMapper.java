/**
 * @file: TeamMessageMapper
 * @author: michael
 * @date: 2020/4/22 16:49
 * @copyright: 南京凯盛
 */
package org.kisen.cloud.mms.common.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.kisen.cloud.mms.common.entity.TeamMessage;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 *
 * @author michael
 * @version 1.0 Created on 2020/4/22 16:49
 */
@Mapper
public interface TeamMessageMapper {

    int insert(TeamMessage TeamMessage);

    int update(TeamMessage TeamMessage);

    int deleteById(long id);

    List<TeamMessage> selectAll();

    TeamMessage selectById(long id);

    int insertSample();

    /**
     * 拉取会话历史记录
     *
     * @param to        群id
     * @param beginTime 查询开始时间
     * @param endTime   查询结束时间
     * @param lastMsgId 查询起点消息
     * @param limit     本次查询限制数量
     * @param reverse   默认false，表示从endTime开始往前查找历史消息; true表示从beginTime开始往后查找历史消息
     * @param asc       表示对查询结果按照时间进行排序的方式： 如果asc和reverse设置相同(都为true，或者都为false)，查询结果按照时间戳从大到小；如果asc和reverse设置不同，查询结果按照时间戳从小到大。
     * @return
     * @author zhouzhixiang
     */
    List<TeamMessage> getHistoryTeamMessagesFromTeam(@Param("to") String to, @Param("beginTime") Long beginTime, @Param("endTime") Long endTime, @Param("lastMsgId") long lastMsgId, @Param("limit") int limit, @Param("reverse") boolean reverse, @Param("asc") boolean asc);

    /**
     * 获取会话最后一条消息的时间戳
     *
     * @param teamId
     * @return
     * @author zhouzhixiang
     */
    Long getLastMsgTimeByTeamId(long teamId);

    /**
     * 撤回群消息
     *
     * @param msgServerId
     * @param deleteTime
     * @return
     */
    int teamWithdrawMsg(long msgServerId, long deleteTime);
}
