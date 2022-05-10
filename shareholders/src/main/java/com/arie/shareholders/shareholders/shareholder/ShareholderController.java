package com.arie.shareholders.shareholders.shareholder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/shareholder")
public class ShareholderController {

    private final ShareholderService shareholderService;

    @Autowired
    public ShareholderController(ShareholderService shareholderService) {
        this.shareholderService = shareholderService;
    }

    @GetMapping
    public List<Shareholder> getShareholders() {
        return shareholderService.getShareholders();
    }

    @PostMapping
    public void registerNewShareholder(@RequestBody Shareholder shareholder){
        shareholderService.addNewShareholder(shareholder);
    }

    @DeleteMapping(path = "{shareholderId}")
    public void deleteShareholder(@PathVariable("shareholderId") Long shareholderId) {
        shareholderService.deleteShareholder(shareholderId);
    }

    @PutMapping(path = "{shareholderId}")
    public void updateShareholder(
            @PathVariable("shareholderId") Long shareholderId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        shareholderService.updateShareholder(shareholderId, name, email);

    }
}
