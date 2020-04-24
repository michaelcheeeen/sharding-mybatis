/**
 * @file: TeamMessageServiceImpl
 * @author: michael
 * @date: 2020/4/22 16:53
 * @copyright: 南京凯盛
 */
package org.kisen.cloud.mms.common.service.impl;

import org.kisen.cloud.mms.common.dao.TeamMessageMapper;
import org.kisen.cloud.mms.common.entity.ConversationMsgVo;
import org.kisen.cloud.mms.common.entity.TeamMessage;
import org.kisen.cloud.mms.common.service.TeamMessageServiceApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 *
 * @author michael
 * @version 1.0 Created on 2020/4/22 16:53
 */

@Service
public class TeamMessageServiceImpl implements TeamMessageServiceApi {

    private static final Logger logger = LoggerFactory.getLogger(TeamMessageServiceImpl.class);

    @Autowired
    private TeamMessageMapper teamMessageMapper;

    @Override
    public int insert(TeamMessage message) {
        return teamMessageMapper.insert(message);
    }

    @Override
    public int insertMsg(ConversationMsgVo message) {
        if (message == null)
            return 0;
        TeamMessage teamMessage = TeamMessage.builder()
                .text(message.getBody())
                .eventType(Integer.parseInt(message.getEventType()))
                .sendId(message.getFromAccount())
                .sendClientIp(message.getIp())
                .sendClientPort(message.getPort())
                .sendClientType(message.getFromClientType())
                .sendDeviceId(message.getFromDeviceId())
                .sendNick(message.getFromNick())
                .sendAt(Long.parseLong(message.getMsgTimestamp()))
                .msgType(message.getMsgType())
                .convType(message.getConvType())
                .teamMsgId(Long.parseLong(message.getMsgidServer()))
                .teamClientMsgId(message.getMsgidClient())
                //.teamId(message.getTo())
                .attach(message.getAttachJson())
                .customApnsText(message.getCustomApnsText())
                .ext(message.getExt())
                .antispam(message.getAntispam())
                .yidunRes(message.getYidunRes())
                .build();
        return teamMessageMapper.insert(teamMessage);
    }

    @Override
    public int insertSample() {
        return this.teamMessageMapper.insertSample();
    }

    @Override
    public TeamMessage selectById(long id) {
        return this.teamMessageMapper.selectById(id);
    }

    @Override
    public List<TeamMessage> getHistoryMessages(String scene, String to, Long beginTime, Long endTime, long lastMsgId, int limit, boolean reverse, boolean asc) throws IllegalArgumentException {
        return null;
    }

    @Override
    public boolean insertMessageWhenSendKafkaError(String message) {
        logger.info("insertMessage message = {}", message);
        boolean result = false;
        try {
//            result = this.processMessage(message);
        } catch (Exception e) {
            logger.error("insertMessage error: ", e);
        } finally {
            logger.info("insertMessage result = {}", result);
            return result;
        }
    }

    @Override
    public Long getLastMsgTimeByTeamId(long teamId) {
        return this.teamMessageMapper.getLastMsgTimeByTeamId(teamId);
    }

    @Override
    public boolean teamWithdrawMsg(long msgServerId, long deleteTime) {
        return this.teamMessageMapper.teamWithdrawMsg(msgServerId, deleteTime) > 0 ? true : false;
    }

    @Override
    public List<TeamMessage> selectAll() {
        return this.teamMessageMapper.selectAll();
    }

    @Override
    public long deleteById(long id) {
        return this.teamMessageMapper.deleteById(id);
    }

}
