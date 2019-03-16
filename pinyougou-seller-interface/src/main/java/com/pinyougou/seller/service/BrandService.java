package com.pinyougou.seller.service;

import java.util.List;
import java.util.Map;

import com.pinyougou.pojo.TbBrand;

import entity.PageResult;

public interface BrandService {
	List<TbBrand> findAll();
	/**
	 * 品牌分页
	 * @param pageNum 当前页面
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(int pageNum,int pageSize);
	
	/**
	 * 添加
	 * @param brand
	 */
	public void add(TbBrand brand);
	/**
	 * 根据id查询实体
	 * @param id
	 * @return
	 */
	public TbBrand findOne(long id );
	/**
	 * 修改
	 * @param brand
	 */
	public void update(TbBrand brand);
	/**
	 * 根据id删除
	 * @param ids
	 */
	public void delete(long[] ids);
	/**
	 * 品牌分页
	 * @param brand 品牌
	 * @param pageNum 当前页面
	 * @param pageSize 每页记录条数
	 * @return
	 */
	public PageResult findPage(TbBrand brand,int page,int size);
	
	public List<Map> selectOptionList(); 
		
	
}
