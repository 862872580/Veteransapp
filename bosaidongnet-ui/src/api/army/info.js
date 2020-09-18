import request from '@/utils/request'

// 查询用户详细信息列表
export function listInfo(query) {
  return request({
    url: '/army/info/list',
    method: 'get',
    params: query
  })
}

// 查询用户详细信息详细
export function getInfo(infoId) {
  return request({
    url: '/army/info/' + infoId,
    method: 'get'
  })
}

// 新增用户详细信息
export function addInfo(data) {
  return request({
    url: '/army/info',
    method: 'post',
    data: data
  })
}

// 修改用户详细信息
export function updateInfo(data) {
  return request({
    url: '/army/info',
    method: 'put',
    data: data
  })
}

// 删除用户详细信息
export function delInfo(infoId) {
  return request({
    url: '/army/info/' + infoId,
    method: 'delete'
  })
}

// 导出用户详细信息
export function exportInfo(query) {
  return request({
    url: '/army/info/export',
    method: 'get',
    params: query
  })
}