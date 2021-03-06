package irinakjoseva.vecnamoda.controller;

import irinakjoseva.vecnamoda.dto.request.ColorRequestDto;
import irinakjoseva.vecnamoda.dto.response.ColorResponseDto;
import irinakjoseva.vecnamoda.service.impl.ColorServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/colors")
public class ColorController {

    private final ColorServiceImpl colorService;

    public ColorController(ColorServiceImpl colorService) {
        this.colorService = colorService;
    }

    @GetMapping("/getall")
    public ResponseEntity<List<ColorResponseDto>> getColors() {
        return ResponseEntity.ok(colorService.getAllColors());
    }

    @PostMapping("/add")
    public ResponseEntity<ColorResponseDto> addColor(@RequestBody @Valid ColorRequestDto colorRequestDto) {
        return ResponseEntity.ok(colorService.addColor(colorRequestDto));
    }

}
