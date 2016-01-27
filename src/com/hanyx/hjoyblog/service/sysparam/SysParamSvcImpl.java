package com.hanyx.hjoyblog.service.sysparam;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hanyx.hjoyblog.bean.ErrorCode;
import com.hanyx.hjoyblog.bean.SysParam;
import com.hanyx.hjoyblog.dao.SysParamDao;
import com.hanyx.hjoyblog.exception.BusiException;
import com.hanyx.hjoyblog.util.GlobalConstraints;
import com.hanyx.hjoyblog.util.StringUtil;

public class SysParamSvcImpl implements ISysParamSvc {
	@Autowired
	private SysParamDao sysParamDao;

	private static Log log = LogFactory.getLog(SysParamSvcImpl.class);

	@Override
	public String getValueByCode(String code) throws Exception{
		String value="";
		try {
			value = sysParamDao.queryOne(
					new Query().addCriteria(Criteria.where("code").is(code)))
					.getValue();
			if (StringUtil.isRealEmpty(value)) {
				log.error("[" + code + "]" + "没有对应的值");
			}
		} catch (Exception e) {
			throw new BusiException(GlobalConstraints.ErrorCode.NULL_POINT);
		}
		return value;
	}

	@Override
	public String getValueByCodeAndKey(String code, String key) {
		String value = sysParamDao.queryOne(
				new Query().addCriteria(Criteria.where("code").is(code))
						.addCriteria(Criteria.where("key").is(key))).getValue();
		if (StringUtil.isRealEmpty(value)) {
			log.error("[" + code + "," + key + "]" + "没有对应的值");
		}
		return value;
	}

	@Override
	public String getValueByKey(String key) {
		String value = sysParamDao.queryOne(
				new Query().addCriteria(Criteria.where("key").is(key)))
				.getValue();
		if (StringUtil.isRealEmpty(value)) {
			log.error("[" + key + "]" + "没有对应的值");
		}
		return value;
	}

	@Override
	public void updateValueByCode(String code, String val) {
		Query query = new Query(Criteria.where("code").is(code));
		Update update = Update.update("value", val);
		sysParamDao.updateInser(query, update);
	}

	@Override
	public void updateValueByCodeAndKey(String code, String key, String value) {
		Query query = new Query(Criteria.where("code").is(code))
				.addCriteria(Criteria.where("key").is(key));
		Update update = Update.update("value", value);
		sysParamDao.updateFirst(query, update);
	}

	@Override
	public void updateValueByKey(String key, String value) {
		Query query = new Query(Criteria.where("key").is(key));
		Update update = Update.update("value", value);
		sysParamDao.updateFirst(query, update);
	}

	@Override
	public void insert(String code, String key, String val) {
        SysParam sysParam=new SysParam();
        sysParam.setCode(code);
        sysParam.setKey(key);
        sysParam.setValue(val);
        sysParamDao.save(sysParam);
	}

}
