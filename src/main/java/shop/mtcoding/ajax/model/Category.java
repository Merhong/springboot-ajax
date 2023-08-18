package shop.mtcoding.ajax.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor // DB 조회 -> PC에 Category 객체 생성 -> 빈생성자를 만들어줌
// NoArg 없으면 조회는 되지만 영속화는 안된다!!!
@Getter
@Setter
@Table(name = "category_tb")
@Entity
public class Category {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private String name; // 백엔드, 프론트엔드, DBA 기술 이름

    @Builder
    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
