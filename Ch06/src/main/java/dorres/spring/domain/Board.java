package dorres.spring.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Board {
	@Id
	@GeneratedValue
	private Long seq;
	
	private String title;
	
	@Column(updatable = false)
	private String writer;
	
	private String content;
	
	@Column(updatable = false, insertable = false, columnDefinition = "date default sysdate")
	private Date createDate;
	
	@Column(updatable = false, insertable = false, columnDefinition = "number default 0")
	private Long cnt;
	

}
