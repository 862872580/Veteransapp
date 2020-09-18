import request from '@/utils/request'

// 查询工作经历列表
export function listWorkexp(query) {
  return request({
    url: '/army/workexp/list',
    method: 'get',
    params: query
  })
}

// 查询工作经历详细
export function getWorkexp(workexpId) {
  return request({
    url: '/army/workexp/' + workexpId,
    method: 'get'
  })
}

// 新增工作经历
export function addWorkexp(data) {
  return request({
    url: '/army/workexp',
    method: 'post',
    data: data
  })
}

// 修改工作经历
export function updateWorkexp(data) {
  return request({
    url: '/army/workexp',
    method: 'put',
    data: data
  })
}

// 删除工作经历
export function delWorkexp(workexpId) {
  return request({
    url: '/army/workexp/' + workexpId,
    method: 'delete'
  })
}

// 导出工作经历
export function exportWorkexp(query) {
  return request({
    url: '/army/workexp/export',
    method: 'get',
    params: query
  })
}