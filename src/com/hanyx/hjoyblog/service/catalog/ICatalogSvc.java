package com.hanyx.hjoyblog.service.catalog;

import java.util.Date;
import java.util.List;

import com.hanyx.hjoyblog.bean.Catalog;

/**
 * @desc: Ŀ¼�����ӿ�
 * @author ÷����
 */
public interface ICatalogSvc {
	public List<Catalog> queryAll();

	public void insert(String string, String string2, Short i, Short j,
			Date nowTime);
}
