package com.hanyx.hjoyblog.service.catalog;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.query.Query;

import com.hanyx.hjoyblog.bean.Catalog;
import com.hanyx.hjoyblog.dao.CatalogDao;

/**
 * @desc: 目录服务层实现
 * @author 梅海风
 */
public class CatalogSvcImpl implements ICatalogSvc {
	@Autowired
	private CatalogDao catalogDao;

	@Override
	public List<Catalog> queryAll() {
		return catalogDao.queryList(new Query().with(new Sort(Direction.ASC,
				"createDate")));

	}

	@Override
	public void insert(String catalogId, String catalogPath, Short permission,
			Short state, Date createDate) {
		Catalog catalog = new Catalog();
		catalog.setCatalogId(catalogId);
		catalog.setCatalogPath(catalogPath);
		catalog.setPermission(permission);
		catalog.setState(state);
		catalog.setCreateDate(createDate);
		catalogDao.save(catalog);
	}

}
