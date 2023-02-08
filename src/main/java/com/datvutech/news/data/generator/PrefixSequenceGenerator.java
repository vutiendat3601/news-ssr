package com.datvutech.news.data.generator;

import java.io.Serializable;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;

public class PrefixSequenceGenerator extends SequenceStyleGenerator {
    public static final String NAME = "PrefixedSequenceGenerator";
    public static final String CLASS_PATH = "com.datvutech.cashlog.data.generator.PrefixSequenceGenerator";

    public static final String PREFIX_PARAM = "prefix";
    public static final String DEFAULT_PREFIX = "";
    private String prefix;

    public static final String NUMBER_FORMAT_PARAM = "numberFormat";
    public static final String DEFAULT_NUMBER_FORMAT = "%d";
    private String numberFormat;

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        return prefix +
                String.format(numberFormat, super.generate(session, object));
    }

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
        super.configure(LongType.INSTANCE, params, serviceRegistry);
        prefix = ConfigurationHelper.getString(PREFIX_PARAM, params, DEFAULT_PREFIX);
        numberFormat = ConfigurationHelper.getString(NUMBER_FORMAT_PARAM, params, DEFAULT_NUMBER_FORMAT);
    }
}
