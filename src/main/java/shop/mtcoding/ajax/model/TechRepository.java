package shop.mtcoding.ajax.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TechRepository extends JpaRepository<Tech, Integer> {

    // select * from tech_tb where category_id = : categoryId
    // JPQL
    @Query("select t from Tech t where t.category.id = :categoryId")
    List<Tech> findByCategoryId(@Param("categoryId") Integer categoryId);
}
