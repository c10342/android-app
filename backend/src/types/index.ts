import { Request, Response, NextFunction } from 'express';

// 自定义错误类型
export class HttpError extends Error {
  statusCode: number;

  constructor(statusCode: number, message: string) {
    super(message);
    this.statusCode = statusCode;
    this.name = 'HttpError';
  }
}

// 统一响应结构
export interface ApiResponse<T = unknown> {
  code: number;
  message: string;
  data?: T;
}

// 错误处理中间件类型
export type ErrorRequestHandler = (
  err: HttpError,
  req: Request,
  res: Response,
  next: NextFunction
) => void;
