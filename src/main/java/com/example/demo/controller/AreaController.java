package com.example.demo.controller;
import com.example.demo.dto.AreaDTO;
import com.example.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/areas")
public class AreaController {

    @Autowired
    AreaService areaService;

    @GetMapping("/areas")
    public String getAreas(Model model) {
        model.addAttribute("area", new AreaDTO());
        return "/views/areas/areas";
    }

    @GetMapping("/deleteArea")
    public String deleteArea(@RequestParam int id) {
        this.areaService.deleteById(id);

        return "redirect:views/areas";
    }

    @GetMapping("/areas/new")
    public String newAreea(Model m) {
        AreaDTO dto = new AreaDTO();
        m.addAttribute("area", dto);

        return "views/areas/newArea";
    }

//    @PostMapping("/areas/save")
//    public String saveOffice(@ModelAttribute("area") AreaDTO dto) {
//   /*     Area area = areaMapper.toEntity(dto);
//        this.areaServiceImpl.saveArea(area);
//*/
//        return "redirect:views/areas";
//    }

//    @GetMapping("/edit")
//    public String editArea(@RequestParam int id, Model m) {
//        Area a = this.areaServiceImpl.findAreaById(id);
//       /* AreaDTO areaDTO = areaMapper.toDTO(a);
//        m.addAttribute("area", areaDTO);
//*/
//        return "views/areas/editArea";
//    }
//
//    @PostMapping("/areas/edit")
//    public String modificarArea(@ModelAttribute("area") AreaDTO areaDto) {
//        System.out.println(" areaId " + areaDto.getId() + " area name " + areaDto.getNombre());
//        /*Area entity = areaMapper.toEntity(areaDto);
//        this.areaServiceImpl.updateArea(entity);
//*/
//        return "redirect:views/areas";
//    }
}
