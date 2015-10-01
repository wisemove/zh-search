package com.zhgw.search.model.question;

import java.util.Date;

import com.zhgw.search.common.Id;
import com.zhgw.search.common.Table;

@Table(name="t_question")
public class QuestionEntity {

	@Id
	private long id ;
	//客户名称
	private String client_name;
	//客户地址
	private String client_address;
	//客户电话
	private String client_phone;
	//提问时间
	private Date ask_time;
	//回复时间
	private Date answer_time;
	//收件人
	private String receiver;
	//发件人
	private String sender;
	//案例编号
	private int case_num;
	//案例标题
	private String case_title;
	//负责人
	private String  custodian;
	//负责人电话
	private String custodian_phone;
	//回复类型 1 邮件，2 文档
	private int  answer_type;
	//问题来源
	private int question_source;
	//问题内容
	private String question;
	//回复内容
	private String answer;
	//发件人部门
	private String sender_depart;
	//收件人部门
	private String receiver_depart;
	//发件人传真
	private String sender_fax;
	//收件人传真
	private String receiver_fax;
	//回复人
	private String answer_people;
	//复核人意见。。0 未查看，1 审批通过，2被驳回
	private int auditor_comment;
	//咨询总监复核人
	private String refer_auditor_boss;
	//复核人
	private String auditor;
	//合伙人审核人
	private String partner_auditor;
	//当前是否适用
	private int is_valid;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	public String getClient_address() {
		return client_address;
	}
	public void setClient_address(String client_address) {
		this.client_address = client_address;
	}
	public String getClient_phone() {
		return client_phone;
	}
	public void setClient_phone(String client_phone) {
		this.client_phone = client_phone;
	}
	public Date getAsk_time() {
		return ask_time;
	}
	public void setAsk_time(Date ask_time) {
		this.ask_time = ask_time;
	}
	public Date getAnswer_time() {
		return answer_time;
	}
	public void setAnswer_time(Date answer_time) {
		this.answer_time = answer_time;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public int getCase_num() {
		return case_num;
	}
	public void setCase_num(int case_num) {
		this.case_num = case_num;
	}
	public String getCase_title() {
		return case_title;
	}
	public void setCase_title(String case_title) {
		this.case_title = case_title;
	}
	public String getCustodian() {
		return custodian;
	}
	public void setCustodian(String custodian) {
		this.custodian = custodian;
	}
	public String getCustodian_phone() {
		return custodian_phone;
	}
	public void setCustodian_phone(String custodian_phone) {
		this.custodian_phone = custodian_phone;
	}
	public int getAnswer_type() {
		return answer_type;
	}
	public void setAnswer_type(int answer_type) {
		this.answer_type = answer_type;
	}
	public int getQuestion_source() {
		return question_source;
	}
	public void setQuestion_source(int question_source) {
		this.question_source = question_source;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getSender_depart() {
		return sender_depart;
	}
	public void setSender_depart(String sender_depart) {
		this.sender_depart = sender_depart;
	}
	public String getReceiver_depart() {
		return receiver_depart;
	}
	public void setReceiver_depart(String receiver_depart) {
		this.receiver_depart = receiver_depart;
	}
	public String getSender_fax() {
		return sender_fax;
	}
	public void setSender_fax(String sender_fax) {
		this.sender_fax = sender_fax;
	}
	public String getReceiver_fax() {
		return receiver_fax;
	}
	public void setReceiver_fax(String receiver_fax) {
		this.receiver_fax = receiver_fax;
	}
	public String getAnswer_people() {
		return answer_people;
	}
	public void setAnswer_people(String answer_people) {
		this.answer_people = answer_people;
	}
	public int getAuditor_comment() {
		return auditor_comment;
	}
	public void setAuditor_comment(int auditor_comment) {
		this.auditor_comment = auditor_comment;
	}
	public String getRefer_auditor_boss() {
		return refer_auditor_boss;
	}
	public void setRefer_auditor_boss(String refer_auditor_boss) {
		this.refer_auditor_boss = refer_auditor_boss;
	}
	public String getAuditor() {
		return auditor;
	}
	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}
	public String getPartner_auditor() {
		return partner_auditor;
	}
	public void setPartner_auditor(String partner_auditor) {
		this.partner_auditor = partner_auditor;
	}
	public int getIs_valid() {
		return is_valid;
	}
	public void setIs_valid(int is_valid) {
		this.is_valid = is_valid;
	}
	
	
	
}
