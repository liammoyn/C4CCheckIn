package com.codeforcommunity.processor;


import com.codeforcommunity.api.IProcessor;
import com.codeforcommunity.dto.MemberReturn;
import org.jooq.generated.tables.pojos.Member;
import com.codeforcommunity.dto.Result;
import org.jooq.DSLContext;
import org.jooq.generated.Tables;

import java.util.List;
import java.util.stream.Collectors;

public class ProcessorImpl implements IProcessor {

  private final DSLContext db;

  public ProcessorImpl(DSLContext db) {
    this.db = db;
  }

  @Override
  public Result createMeeting(String meetingName) {
    return null;
  }

  @Override
  public Result checkIn(String meetingId, String email) {
    return null;
  }

  @Override
  public Result createMember() {
    return null;
  }

  @Override
  public Result closeMeeting(String meetingId) {
    return null;
  }

  @Override
  public List<MemberReturn> getAttendees() {
    List<Member> members = db.selectFrom(Tables.MEMBER).fetchInto(Member.class);
    return members.stream()
        .map(member -> new MemberReturn(member.getFirstName(), member.getLastName()))
        .collect(Collectors.toList());
  }
}
