package com.telly.controllers;

public class BusController {
    @Autowired
    BusService busService;


    @RequestMapping("/createtrip")
    public String reserveBus(Model model, Principal principal) {

        model.addAttribute("bus", new Bus());

        return "createtrip";
    }

    @RequestMapping(value = "/createreserve", method = RequestMethod.POST)
    public String createReserve(@Validated(FormValidationGroup.class) Bus bus, BindingResult result,
                                Principal principal) {

        if (result.hasErrors()) {
            return "reservebus";
        }

        busService.create(bus);

        return "home";

    }
}
