package ru.gb.springboot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.springboot.entity.Message;
import ru.gb.springboot.service.MessageService;


@Controller
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    // форма для создания сообщения
    @RequestMapping(path = "/create", method = RequestMethod.GET)
    public String showSimpleForm(Model model){
        Message message = new Message();
        model.addAttribute("message", message);
        return "create-message";
    }

    // обработка формы создания и редактирования сообщений
    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public String processForm(Message message){
        if(message.getId() == null){
            messageService.save(message);
        } else {
            messageService.edit(message);
        }
        return "redirect:/message/all";
    }

    // показать один элемент
    @RequestMapping(path = "/{id}", method = RequestMethod.GET) //localhost:8080/spring/message/{id}
    public String getMessageById(Model model,
                                 @PathVariable Integer id,
                                 @RequestParam(name = "random", defaultValue = "false", required = false) Boolean isRandom){
        Message message;

        if(isRandom){
            message = messageService.getRandomMessage();
        } else {
            message = messageService.findById(id);
        }

        model.addAttribute("message", message);

        return "message";
    }

    // показать все элементы
    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public String getAllMessages(Model model){
        model.addAttribute("messages", messageService.findAll());
        return "message-list";
    }

    // удаление элемента /message/delete/{id}
    @RequestMapping(path = "/delete", method = RequestMethod.GET)
    public String deleteById(@RequestParam Integer id){
        messageService.deleteById(id);
        return "redirect:/message/all";
    }

    @RequestMapping(path = "/edit", method = RequestMethod.GET)
    public String editById(Model model, @RequestParam Integer id){
        Message message = messageService.findById(id);
        model.addAttribute("message", message);
        return "create-message";
    }

/*    private final ru.gb.springbootlesson.MessageProvider messageProvider;

    @RequestMapping
    public String printMessage(Model model){
        model.addAttribute("msg", messageProvider.getMessage());
        return "message";
    }

    @ModelAttribute("info")
    public String addAttribute(){
        return "added info for all methods in controller";
    }
*/
}

