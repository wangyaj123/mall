package com.office.mall.web.commons;


//import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class BaseConverter<S, T> {

    public BaseConverter() {
    }

    public T convert(S s, Class<T> clazz) {
        Object t = null;

        try {
            t = clazz.newInstance();
        } catch (Exception var5) {

        }

        if (s != null) {
            this.convert(s, (T) t);
        }

        return (T) t;
    }

    public List<T> convert(List<S> fromList, Class<T> clazz) {
        if (CollectionUtils.isEmpty(fromList)) {
            return new ArrayList();
        } else {
            List<T> toList = new ArrayList();
            Iterator var4 = fromList.iterator();

            while(var4.hasNext()) {
                S from = (S) var4.next();
                toList.add(this.convert(from, clazz));
            }

            return toList;
        }
    }

    protected void convert(S s, T t) {
        BeanUtils.copyProperties(s, t);
    }
}
