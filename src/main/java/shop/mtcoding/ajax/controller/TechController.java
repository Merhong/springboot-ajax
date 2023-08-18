package shop.mtcoding.ajax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import shop.mtcoding.ajax.dto.TechResponse;
import shop.mtcoding.ajax.model.Category;
import shop.mtcoding.ajax.model.CategoryRepository;
import shop.mtcoding.ajax.model.Tech;
import shop.mtcoding.ajax.model.TechRepository;

import java.util.List;

@Controller
public class TechController {

    // Dependecy Injection
    @Autowired
    private TechRepository techRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @GetMapping("/v1/test/tech")
    public @ResponseBody TechResponse.MainDTO techV1() {
        List<Category> categoryList = categoryRepository.findAll();
        List<Tech> techList = techRepository.findByCategoryId(1);
        System.out.println("=============================");
        TechResponse.MainDTO mainDTO = new TechResponse.MainDTO(categoryList, techList);
        return mainDTO; // MessageConverter 발동 : JSON 변환시 lazyloading 발동 category 조회됨
    }

    // 목적 : 오직 Tech만 들고오고 싶음
    @GetMapping("/v2/test/tech")
    public @ResponseBody List<Tech> techV2() {
        List<Tech> techList = techRepository.findByCategoryId(1);
        return techList; // MessageConverter 발동 : JSON 변환시 lazyloading 발동 category 조회됨
    }

    // 1. 빈껍데기 디자인을 준다. (데이터 없음)
    @GetMapping("/tech")
    public String tech() {
        return "main";
    }

    // 2. JavaScript에서 불러오는 api
    @GetMapping("/api/category")
    public @ResponseBody List<Category> category() {
        return categoryRepository.findAll();
    }

    @GetMapping("/api/tech")
    public @ResponseBody List<Tech> techApi(@RequestParam(defaultValue = "1") Integer categoryId) {
        return techRepository.findByCategoryId(categoryId);
    }


}
