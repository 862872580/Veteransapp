import request from '@/utils/request'

// 查询教育经历列表
export function listEduexp(query) {
  return request({
    url: '/army/eduexp/list',
    method: 'get',
    params: query
  })
}

// 查询教育经历详细
export function getEduexp(eduexpId) {
  return request({
    url: '/army/eduexp/' + eduexpId,
    method: 'get'
  })
}

// 新增教育经历
export function addEduexp(data) {
  return request({
    url: '/army/eduexp',
    method: 'post',
    data: data
  })
}

// 修改教育经历
export function updateEduexp(data) {
  return request({
    url: '/army/eduexp',
    method: 'put',
    data: data
  })
}

// 删除教育经历
export function delEduexp(eduexpId) {
  return request({
    url: '/army/eduexp/' + eduexpId,
    method: 'delete'
  })
}

// 导出教育经历
export function exportEduexp(query) {
  return request({
    url: '/army/eduexp/export',
    method: 'get',
    params: query
  })
}