import request from '@/utils/request'

// 查询工作列表
export function listWork(query) {
  return request({
    url: '/army/work/list',
    method: 'get',
    params: query
  })
}

// 查询工作详细
export function getWork(workId) {
  return request({
    url: '/army/work/' + workId,
    method: 'get'
  })
}

// 新增工作
export function addWork(data) {
  return request({
    url: '/army/work',
    method: 'post',
    data: data
  })
}

// 修改工作
export function updateWork(data) {
  return request({
    url: '/army/work',
    method: 'put',
    data: data
  })
}

// 删除工作
export function delWork(workId) {
  return request({
    url: '/army/work/' + workId,
    method: 'delete'
  })
}

// 导出工作
export function exportWork(query) {
  return request({
    url: '/army/work/export',
    method: 'get',
    params: query
  })
}