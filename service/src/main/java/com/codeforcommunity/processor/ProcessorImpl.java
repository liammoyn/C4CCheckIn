package com.codeforcommunity.processor;


import com.codeforcommunity.api.IProcessor;
import com.codeforcommunity.dto.Member;
import com.codeforcommunity.dto.Result;
import org.jooq.DSLContext;

import java.util.List;

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
  public List<Member> getAttendees() {
    return null;
  }
}
