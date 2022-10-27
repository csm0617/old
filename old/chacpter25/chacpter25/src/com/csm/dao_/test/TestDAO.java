package com.csm.dao_.test;
import com.csm.dao_.dao.ActorDAO;
import com.csm.dao_.domian.Actor;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @Author 快乐小柴
 * @Date 2022/9/23 11:32
 * @Version 1.0
 */
public class TestDAO {
    @Test
    public void testActorDAO(){
        ActorDAO actorDAO = new ActorDAO();
        //1.查询
        List<Actor> actors = actorDAO.queryMulti("select * from Actor where id >= ?", Actor.class, 1);
        for (Actor actor : actors) {
            System.out.println(actor);
        }
        //2.查询单行记录
        Actor actor = actorDAO.querySingle("select * from Actor where id = ?", Actor.class, 1);
        System.out.println("================单行查询结果==========");
        System.out.println(actor);
        //3.查询单行单列
        Object o = actorDAO.queryScalar("select name from Actor where id = ?", 5);
        System.out.println("================查询单列的值=========");
        System.out.println(o);
        //4.dml操作，
        //insert
//        int update = actorDAO.update("insert into Actor values(7,'狗蛋','2000-01-01','15496543270')");
//        System.out.println(update>0 ? "插入成功":"插入失败");
        //update
//        int update = actorDAO.update("update Actor set name='张全蛋' where id=?", 7);
//        System.out.println(update>0 ? "修改成功":"修改失败");
        //delete
//        int update= actorDAO.update("delete from Actor where name=?", "张全蛋");
//        System.out.println(update>0 ? "删除成功":"删除失败");

    }

}
