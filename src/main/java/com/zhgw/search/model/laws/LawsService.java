package com.zhgw.search.model.laws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zhgw.search.common.Conditions;
import com.zhgw.search.dao.CommonDao;

@Service
public class LawsService extends CommonDao<LawsEntity> {

	/**
	 * 根据id 获取法规的所有内容
	 * 
	 * @param _id
	 * @return
	 */
	public List<LawsEntity> getAllLaws(String _id) {

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


		
		return down_laws;
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

}
