package com.foxiswho.springbootjpademo.generator.id;

import com.foxiswho.springbootjpademo.util.FieldUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;

import java.io.Serializable;

@Slf4j
public class CustomIDGenerator extends IdentityGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        log.info(" object ={}", object);
        //自定义主键，是否存在，如果存在那么 把自定义主键值复制给  主键id
        Object idCustom = FieldUtil.getFieldValueByName("idCustomPrimaryKey", object);
        if (idCustom != null) {
            return (Serializable) idCustom;
        }
        //如果主键为空，那么 生成新的主键
        Object id = FieldUtil.getFieldValueByName("id", object);
        if (id != null) {
            return (Serializable) id;
        }
        return super.generate(session, object);
    }
}
