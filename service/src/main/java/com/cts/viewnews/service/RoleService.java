package com.cts.viewnews.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.viewnews.bean.Language;
import com.cts.viewnews.bean.Role;
import com.cts.viewnews.dao.RoleRepository;

@Service
public class RoleService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RoleService.class);

	@Autowired
	private RoleRepository roleRepository;

	@Transactional
	public List<Role> findAllRoles() {
		LOGGER.info("Inside of findAllRoles() method of RoleService");
		return roleRepository.findAll();
	}

}
