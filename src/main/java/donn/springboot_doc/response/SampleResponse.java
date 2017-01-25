package donn.springboot_doc.response;

import javax.xml.bind.annotation.XmlRootElement;

import donn.springboot_doc.request.SampleRequest;

@XmlRootElement
public class SampleResponse extends BaseResponse {
	private Integer id;
	private String name;
	private String info;
	
	public SampleResponse(SampleRequest sample) {
		this.id = sample.getSid();
		this.name = sample.getSname();
		this.info = sample.getSinfo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
