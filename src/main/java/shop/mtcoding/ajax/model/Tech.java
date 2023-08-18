package shop.mtcoding.ajax.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor // DB 조회 -> PC에 Category 객체 생성 -> 빈생성자를 만들어줌
// NoArg 없으면 조회는 되지만 영속화는 안된다!!!
@Getter
@Setter
@Table(name = "tech_tb")
@Entity
public class Tech {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private String name; // Java, Spring, Python, C, C++ 등등 기술의 이름

    //  Lazy Loading 방지
    // @JsonIgnore // 실무에선 잘 안쓰고 DTO를 사용한다.
    @ManyToOne(fetch = FetchType.LAZY) // Many쪽에 FK를 가지고 있음!
    private Category category;
}
