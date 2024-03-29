package com.example.attendancekt.model.repo

import com.example.attendancekt.model.dao.MemberDao
import com.example.attendancekt.model.entity.Member

class MemberRepo(private val dao: MemberDao) {

    fun save(member: Member) {
        if(member.id > 0) {
            dao.update(member)
        } else {
            dao.insert(member)
        }
    }

    fun getMember(id: Int) = dao.getMember(id)

    fun getMemberSync(id: Int) = dao.getMemberSync(id)

    fun getAllMember() = dao.getAllMember()

    fun deleteById(id: Int) = delete(dao.getMemberSync(id))

    private fun delete(member: Member) = dao.delete(member)

}