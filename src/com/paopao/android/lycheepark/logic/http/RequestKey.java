package com.paopao.android.lycheepark.logic.http;

public class RequestKey {
	public static final String HTTP_CODE = "httpCode";

	public static final String RESULT_CODE = "resultCode";

	public static final String TOKEN = "token";
	public static final String SERVICE_TOKEN = "serviceToken";
	public static final String SERVICE_ADDRESS = "ServerAddress";
	public static final String CONNECTIONSTRING = "ConnectionString";

	public static final String REQUEST_TYPE = "type";

	public static final String UPDATE_DOWNLOADURL = "downloadUrl";

	public static final String IMEI = "imei";

	public static final String MAX_COUNT = "count";

	public static final String USER = "UserInfo";

	// geo point
	public static final String LONGITUDE = "longitude";
	public static final String LATITUDE = "latitude";

	public static final String PAGE_INDEX = "pageIndex";// page
	public static final String COUNT_PER_PAGE = "pageSize";// page

	// update
	public static final String CHECKUPDATE_VERSION = "version";

	public static final String CHECKUPDATE_NEED_UPDATE = "needUpdate";

	public static final String CHECKUPDATE_FORCE_UPDATE = "forceUpdate";

	public static final String CHECKUPDATE_UPDATE_DESC = "updateDesc";

	// regist
	public static final String REGISTER_PHONE = "phone";
	public static final String REGISTER_SMSCODE = "code";
	public static final String REGISTER_PASSWORD = "passWord";

	// user
	public static final String USER_INFO = "userInfo";
	public static final String USER_UID = "userId";
	public static final String USER_NAME = "name";
	public static final String USER_PID = "pId";
	public static final String USER_PASSWORD = "passWord";
	public static final String USER_UPDATETYPE = "editType";
	public static final String USER_UPDATE_CONTENT = "parameter";

	public static final String USER_ACCOUNT_ID = "AccountID";
	public static final String USER_ACCOUNT_NAME = "AccountName";
	public static final String USER_ACCOUNT_HEADURL = "AccountIconUrl";
	public static final String USER_ACCOUNT_REMARK = "AccountRemark";

	public static final String USER_ACCOUNT_PID = "ProfessionalID";
	public static final String USER_ACCOUNT_SEX = "AccountSex";
	public static final String USER_ACCOUNT_PHONE = "AccountPhone";
	public static final String USER_ACCOUNT_ADDRESS = "AccountAddress";
	public static final String USER_COMPANY_NAME = "CompanyName";

	public static final String POI_INFO = "storesList";
	public static final String POI_ADDRESS = "ShopAddress";
	public static final String POI_CITY = "city";
	public static final String POI_TYPE = "ShopType";
	public static final String POI_SOURCE = "Source";
	public static final String POI_NAME = "ShopTitle";
	public static final String POI_PHONENUM = "ShopPhone";
	public static final String POI_POSTCODE = "postCode";
	public static final String POI_UID = "UUID";
	public static final String POI_SID = "ShopID";
	public static final String POI_REMARK_NAMEE = "RemarkShopName";
	public static final String POI_REMARK_PHONE = "RemarkTel";
	public static final String POI_REMARK_ADDRESS = "RemarkAddress";
	public static final String POI_REMARK_CONTACTS = "RemarkContact";

	// im
	public static final String INVITATION_FRIEND_ID = "friendsID";

	public static final String GROUP_SEARCH_NAME = "groupName";
	public static final String GROUP_ID = "CrowdID";
	public static final String GROUP_MENBER_ID = "memberId";
	
	
	//im plaza topic
	public static final String GET_TOPIC = "getTopic";
	public static final String GET_HOT_TOPIC = "getHotTopic";
	public static final String TOPIC_ID = "id";
	public static final String TOPIC_CONTENT = "topicContent";
	public static final String TOPIC_CREATE_TIME = "createDate";
	public static final String ACCOUNT_NAME = "accountName";
	public static final String LIKE_COUNT = "likeCount";
	public static final String REPLY_COUNT = "replyCount";
	public static final String ACCOUNT_ICON_URL = "accountIconUrl";
	public static final String TO_ACCOUNT_ICON_URL = "toaccountIconUrl";
	public static final String TOPIC_COUNT = "count";
	
	//im plaza reply
	public static final String GET_REPLY = "getReply";
	public static final String COMMENT_INFO_ID = "id";
	public static final String COMMENT_USER_ID = "userId";
	public static final String COMMENT_USER_NAME = "nickName";
	public static final String ACCOUNTICON_URL = "accountIconUrl";
	public static final String COMMENT_CONTENT = "typeContent";
	public static final String COMMENT_TIME = "createDate";
	public static final String TOPICID = "topicId";
	public static final String TO_USER_ID = "touserId";
	public static final String TO_NICK_NAME = "tonickName";
	public static final String ANONYMITY = "anonymity";
	
	//im post new message
	public static final String POST_COMMENT_TYPE = "postMessage";
	
	//im praise
	public static final String POST_PRAISE_TYPE = "createTopicLike";
	public static final String IS_LIKE = "isLike";
	
	//create topic reply
	public static final String CREATE_TOPIC_REPLY_TYPE = "createReply";
	public static final String CREATE_TOPIC_REPLY_CONTENT = "content";
	public static final String TO_ANONYMITY = "toanonymity";
	
	//get unRead message count
	public static final String UN_READ_MESSAGE_COUNT_TYPE = "getMessageCount";
	public static final String UN_READ_MESSAGE_COUNT = "count";
	
	//get new received message
	public static final String GET_NEW_MESSAGE_TYPE = "getPushMessage";
	public static final String  REPLY_CONTENT = "replyContent";
	public static final String  FROM_USER_ID = "fromuserId";
	public static final String  MESSAGE_STATUS = "status";
	public static final String  REPLY_TIME = "replyTime";
	public static final String  MESSAGE_ACCOUNT_NAME = "accountName";
	public static final String  MESSAGE_TO_ACCOUNT_NAME = "toaccountName";
	
	//clear all message
	public static final String CLEAR_ALL_MESSAGE_TYPE = "clearAllMessage";
	
	

	// team
	public static final String TEAM_ID = "teamID";
	public static final String TEAM_INFO_CONTENT = "NoticeContent";
	public static final String TEAM_INFO_TYPE = "NoticeType";
	public static final String TEAM_INFO_ID = "NoticeID";
	public static final String TEAM_INFO_DATE = "CreateTime";
	public static final String TEAM_LAST_NOTICE_TIME_KEY = "time";
	
}
