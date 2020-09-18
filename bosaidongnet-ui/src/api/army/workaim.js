import request from '@/utils/request'

// 查询求职意向列表
export function listWorkaim(query) {
  return request({
    url: '/army/workaim/list',
    method: 'get',
    params: query
  })
}

// 查询求职意向详细
export function getWorkaim(workaimId) {
  return request({
    url: '/army/workaim/' + workaimId,
    method: 'get'
  })
}

// 新增求职意向
export function addWorkaim(data) {
  return request({
    url: '/army/workaim',
    method: 'post',
    data: data
  })
}

// 修改求职意向
export function updateWorkaim(data) {
  return request({
    url: '/army/workaim',
    method: 'put',
    data: data
  })
}

// 删除求职意向
export function delWorkaim(workaimId) {
  return request({
    url: '/army/workaim/' + workaimId,
    method: 'delete'
  })
}

// 导出求职意向
export function exportWorkaim(query) {
  return request({
    url: '/army/workaim/export',
    method: 'get',
    params: query
  })
}