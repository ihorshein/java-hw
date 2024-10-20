package org.ihorshein.lesson3;

class Grade {
  /**
   * Name of the subject.
   */
  private String subject;

  /**
   * Score obtained in the subject.
   */
  private double score;

  Grade(String subject, double score) {
    this.subject = subject;
    this.score = score;
  }

  public String getSubject() {
    return subject;
  }

  public double getScore() {
    return score;
  }
}
