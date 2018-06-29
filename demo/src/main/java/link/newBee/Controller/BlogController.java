package link.newBee.Controller;

import link.newBee.Entity.Blog;
import link.newBee.serviceImpl.BlogServiceImpl;
import link.newBee.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * data 2018-06-28   02:47
 * E-mail   sis.nonacosa@gmail.com
 * @author sis.nonacosa
 */
@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    BlogServiceImpl blogService;



    @RequestMapping(value = "/getBlogById/{id}", method = RequestMethod.GET)
    public Result<Blog> getBlogById (@PathVariable Long id){
        return Result.ok(blogService.getBlogById(id));
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST,consumes = "application/json")
    public Result<Blog> insert(@RequestBody Blog blog){
        return Result.ok(blogService.saveBlog(blog));

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Result<Page<Blog>> getAllBlog(){
        return Result.ok(blogService.getAllBlog());

    }

}
