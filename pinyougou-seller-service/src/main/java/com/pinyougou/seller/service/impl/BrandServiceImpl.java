package com.pinyougou.seller.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.pojo.TbBrandExample.Criteria;
import com.pinyougou.seller.service.BrandService;

import entity.PageResult;

@Service
@Transactional
public class BrandServiceImpl implements BrandService {

	@Autowired
	private TbBrandMapper brandMapper;

	@Override
	public List<TbBrand> findAll() {
		// TODO Auto-generated method stub
		return brandMapper.selectByExample(null);
	}
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		//分页通过插件在方法前写
		PageHelper.startPage(pageNum, pageSize);
		Page<TbBrand> page=(Page<TbBrand>) brandMapper.selectByExample(null);
		return new PageResult(page.getTotal(),page.getResult());
		 
	}
	/**
	 * 添加
	 */
	@Override
	public void add(TbBrand brand) {
		brandMapper.insert(brand);
		}
	/**
	 * 根据id查询实体
	 * @param id
	 * @return
	 */
	public TbBrand findOne(long id){
		return brandMapper.selectByPrimaryKey(id);
	}
	/**
	 * 修改
	 */
	@Override
	public void update(TbBrand brand) {
		brandMapper.updateByPrimaryKey(brand);
	}
	/**
	 * 根据id删除
	 */
	@Override
	public void delete(long[] ids) {
		for(Long id:ids){
			brandMapper.deleteByPrimaryKey(id);
		}
		
		}
	/**
	 * 品牌分页
	 */
	public PageResult findPage(TbBrand brand,int pageNum,int pageSize){
		PageHelper.startPage(pageNum, pageSize);//分页
		TbBrandExample example=new TbBrandExample();
		Criteria criteria=example.createCriteria();
		if(brand!=null){
			if(brand.getName()!=null&&brand.getName().length()>0){
				criteria.andNameLike("%"+brand.getName()+"%");
			}if(brand.getFirstChar()!=null&&brand.getFirstChar().length()>0){
				criteria.andNameLike("%"+brand.getFirstChar()+"%");
			}
		}
		Page<TbBrand> page = (Page<TbBrand>) brandMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
		
	}
	@Override
	public List<Map> selectOptionList() {
		// TODO Auto-generated method stub
		return brandMapper.selectOptionList();
	}
	
}
