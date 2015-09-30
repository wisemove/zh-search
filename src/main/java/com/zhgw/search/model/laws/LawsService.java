package com.zhgw.search.model.laws;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.zhgw.search.common.Conditions;
import com.zhgw.search.dao.CommonDao;

@Service
public class LawsService extends CommonDao<LawsEntity> {

	
	private Logger logger = LoggerFactory.getLogger(LawsService.class);
	/**
	 * 根据id 获取法规的所有内容
	 * 
	 * @param _id
	 * @return
	 */
	public List<LawsEntity> getAllLaws(String _id) {

		List<LawsEntity> return_list = new ArrayList<LawsEntity>();
		List<LawsEntity> down_laws = new ArrayList<LawsEntity>();

		if (_id == null || _id.equals("1")) {
			return down_laws;
		}

		LawsEntity entity = this.get(_id);
		// 查找顶点Id
		LawsEntity law = entity;
		long cpid = law.getParentId();
		while (cpid != 1) {
			law = get(cpid);
			cpid = law.getParentId();
		}

		// 向下查找法规内容
		_laws_entity_.clear();
		down_laws = recursiveFindLaws(law);
		return_list.add(law);
		return_list.addAll(down_laws);
		return return_list;
	}

	private List<LawsEntity> _laws_entity_ = new ArrayList<LawsEntity>();

	// 递归向下查找。
	private List<LawsEntity> recursiveFindLaws(LawsEntity en) {

		long id = en.getId();

		List<LawsEntity> list = queryAll(new Conditions().eq("parentId", id));

		if (list != null && list.size() != 0) {
			_laws_entity_.addAll(list);

			for (LawsEntity le : list) {
				recursiveFindLaws(le);
			}
		}

		return _laws_entity_;
	}

	/**
	 * 循环向下查找删除法规
	 * 
	 * @param id
	 */
	public void deleteLaws(LawsEntity en) {

		synchronized (_laws_entity_) {
			_laws_entity_.clear();
		}
		List<LawsEntity> list = new ArrayList<LawsEntity>();
		list.add(en);
		list.addAll(recursiveFindLaws(en));

		for (LawsEntity le : list) {
			// this.deleteLaws(le);
			logger.info("删除的法规名称:" + ToStringBuilder.reflectionToString(le));
		}

	}
}
