package com.emp.dao;

import com.emp.domain.Employee;
import com.limovue.common.util.CommonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;

/**
 * 通过JPA的Criteria API实现
 */
@Repository
public class EmpDao {

    /**
     * 1.EntityManager获取CriteriaBuilder
     */
    //@Autowired 和 @PersistenceContext 注解任取一
    @Autowired
    EntityManager em;

    /**
     * 根据不同的条件查询
     *
     * @param param
     * @return
     */
    public List<Employee> queryByParams(Map<String, Object> param) {
        List<Employee> emps = null;
        if (CommonUtils.isExist(param)) {
            //2.CriteriaBuilder创建CriteriaQuery
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Employee> query = cb.createQuery(Employee.class);

            //3.CriteriaQuery指定要查询的表，得到Root<Employee>，Root代表要查询的表
            //from
            Root<Employee> root = query.from(Employee.class);
            //4.CriteriaBuilder创建条件Predicate，Predicate相对于SQL的where条件，多个Predicate可以进行与、或操作。
            Predicate predicate = null;

            String id = param.get("id") == null ? "" : param.get("id").toString();
            String name = param.get("name") == null ? "" : param.get("name").toString();
            String gender = param.get("gender") == null ? "" : param.get("gender").toString();
            String birthday = param.get("birthday") == null ? "" : param.get("birthday").toString();
            String email = param.get("email") == null ? "" : param.get("email").toString();

            if (StringUtils.isNotBlank(id)) {
                Predicate p2 = cb.equal(root.get("id"), id);
                if (predicate != null) {
                    predicate = cb.and(predicate, p2);
                } else {
                    predicate = p2;
                }
            }
            if (StringUtils.isNotBlank(birthday)) {
                Predicate p2 = cb.equal(root.get("birthday"), birthday);
                if (predicate != null) {
                    predicate = cb.and(predicate, p2);
                } else {
                    predicate = p2;
                }
            }
            if (StringUtils.isNotBlank(email)) {
                Predicate p2 = cb.equal(root.get("email"), email);
                if (predicate != null) {
                    predicate = cb.and(predicate, p2);
                } else {
                    predicate = p2;
                }
            }
            if (StringUtils.isNotBlank(gender)) {
                Predicate p2 = cb.equal(root.get("gender"), gender);
                if (predicate != null) {
                    predicate = cb.and(predicate, p2);
                } else {
                    predicate = p2;
                }
            }
            if (StringUtils.isNotBlank(name)) {
                Predicate p2 = cb.like(root.get("name"), name);
                if (predicate != null) {
                    predicate = cb.and(predicate, p2);
                } else {
                    predicate = p2;
                }
            }
            query.where(predicate);

            emps = em.createQuery(query).getResultList();
        }
        return emps;
    }

    /**
     * 查询所有的数据
     *
     * @return
     */
    public List<Employee> queryAll() {
        List<Employee> emps = null;
        //2.CriteriaBuilder创建CriteriaQuery
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> query = cb.createQuery(Employee.class);

        //3.CriteriaQuery指定要查询的表，得到Root<Employee>，Root代表要查询的表
        //from
        Root<Employee> root = query.from(Employee.class);
        Predicate p = cb.equal(root.get("id"), 1);

        query.where(p);

        return em.createQuery(query).getResultList();
    }
}
