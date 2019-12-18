package pe.com.paperclip.shame;

public class ActionResponse {
	
	private Long responseId;
	private String status;
	private String message;
	private Object data;

	public ActionResponse(Long responseId) {
		this.responseId = responseId;
	}
	
	public Object getData() {
		return data;
	}

	public Long getResponseId() {
		return responseId;
	}

	public void setResponseId(Long responseId) {
		this.responseId = responseId;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
