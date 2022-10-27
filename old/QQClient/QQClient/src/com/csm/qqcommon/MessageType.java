package com.csm.qqcommon;

/**
 * @Author 快乐小柴
 * @Date 2022/9/16 19:19
 * @Version 1.0
 */
public interface MessageType {
    //不同常量表示消息的不同；类型
    String MESSAGE_LOGIN_SUCCEED = "1";//登陆成功
    String MESSAGE_LOGIN_FAIL = "2";//登录失败
    String MESSAGE_COM_MES = "3";//普通信息包
    String MESSAGE_GET_ONLINE_FRIEND = "4";//要求返回在线用户列表
    String MESSAGE_RET_ONLINE_FRIEND = "5";//返回在线用户列表
    String MESSAGE_CLIENT_EXIT = "6";//客户端请求退出
    String MESSAGE_TO_ALL_MES = "7";//群发消息
    String MESSAGE_FILE_MES="8";//文件消息
}
