package ua.pb.currency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.pb.currency.model.Currency;
import ua.pb.currency.service.CurrencyService;

@Controller
public class CurrencyController {

    private CurrencyService currencyService;

    @Autowired(required = true)
    @Qualifier(value = "currencyService")
    public void setCurrencyService(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @RequestMapping(value = "currency", method = RequestMethod.GET)
    public String listCurrency(Model model) {
        model.addAttribute("currency", new Currency());
        model.addAttribute("listCurrency", this.currencyService.listCurrency());
        return "currency";
    }

    @RequestMapping(value = "/currency/add", method = RequestMethod.POST)
    public String addCurrency(@ModelAttribute("currency") Currency currency) {
        if (currency.getId() == 0) {
            this.currencyService.addCurrency(currency);
        } else {
            this.currencyService.updateCurrency(currency);
        }
        return "redirect:/currency";
    }

    @RequestMapping("/remove/{id}")
    public String removeCurrency(@PathVariable("id") int id) {
        this.currencyService.removeCurrency(id);
        return "redirect:/currency";
    }

    @RequestMapping("edit/{id}")
    public String editCurrency(@PathVariable("id") int id, Model model) {
        model.addAttribute("currency", this.currencyService.getCurrencyById(id));
        model.addAttribute("listCurrency", this.currencyService.listCurrency());
        return "currency";
    }

    @RequestMapping("currencyData/{id}")
    public String currencyData(@PathVariable("id") int id, Model model) {
        model.addAttribute("currency", this.currencyService.getCurrencyById(id));
        return "currencydata";
    }
}
