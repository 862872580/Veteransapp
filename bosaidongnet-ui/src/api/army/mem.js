import request from '@/utils/request'

// 查询用户列表
export function listMem(query) {
  return request({
    url: '/army/mem/list',
    method: 'get',
    params: query
  })
}

// 查询用户详细
export function getMem(memId) {
  return request({
    url: '/army/mem/' + memId,
    method: 'get'
  })
}

// 新增用户
export function addMem(data) {
  return request({
    url: '/army/mem',
    method: 'post',
    data: data
  })
}

// 修改用户
export function updateMem(data) {
  return request({
    url: '/army/mem',
    method: 'put',
    data: data
  })
}

// 删除用户
export function delMem(memId) {
  return request({
    url: '/army/mem/' + memId,
    method: 'delete'
  })
}

// 导出用户
export function exportMem(query) {
  return request({
    url: '/army/mem/export',
    method: 'get',
    params: query
  })
}