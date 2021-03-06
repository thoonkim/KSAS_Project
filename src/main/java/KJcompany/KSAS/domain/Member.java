package KJcompany.KSAS.domain;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(of="userNo")
@ToString
@Entity
@Table(name="member")
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_no")
	private Long userNo;
	
	@NotBlank(message = "아이디는 필수 입력 값입니다.")
	@Column(unique = true, length = 50, nullable = false)
	private String userId;
	
	@NotBlank(message = "비밀번호는 필수 입력 값입니다.")
	@Column(length = 200, nullable = false)
	private String userPw;

/*	@NotBlank(message = "비밀번호를 확인해 주세요.")
	@Column(length = 200, nullable = false)
	private String userPw2;*/
	
	@NotBlank(message = "닉네임은 필수 입력 값입니다.")
	@Column(length = 100, nullable = false)
	private String userName;
	
	@Column(length = 3, nullable = false)
	private String job;
	
	private int coin;
	
	@CreationTimestamp
	private LocalDateTime regDate;
	@UpdateTimestamp
	private LocalDateTime updDate;

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "user_no")
	private List<MemberAuth> authList = new ArrayList<MemberAuth>();

	public void addAuth(MemberAuth auth) {
		authList.add(auth);
	}

	public void clearAuthList() {
		authList.clear();
	}

}
